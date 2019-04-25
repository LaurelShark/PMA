<template>

    <el-form label-position="top">
      <div v-for="(item, index) in form.items"
        :key="index">
        <h2>
          Receipt line
        </h2>
        <el-form-item label="Good id">  
          <el-select
            v-model="form.items[index].id"
          >
            <el-option
              v-for="item in goods"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Amount">
          <el-input v-model.number="form.items[index].amount">
          </el-input>
        </el-form-item>
      </div>
      
      <el-button
        type="success"
        @click="addItem"
      >
        Add new
      </el-button>
      
      <el-button
        type="success"
        @click="onSubmit"
      >
        Create
      </el-button>
      
    </el-form>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadGoods()
  },

  data() {
    return {
      form: {
        items: [
          {
            id: null,
            amount: null,
          }
        ]
      },
    }
  },

  computed: {
    ...mapState('Goods', [
      'goods'
    ])
  },

  methods: {
    ...mapActions('Receipts', [
      'createReceipt'
    ]),

    ...mapActions('Goods', [
      'loadGoods'
    ]),

    addItem() {
      this.form.items.push(
        {
          id: null,
          amount: null,
          price: null
        }
      )
    },

    async onSubmit() {
      try {
        const goods = this.form.items.reduce((res, { id, amount }) => {
          return {
            ...res,
            [`${id}`]: `${amount}`
          }
        }, {})

        console.log(goods)

        await this.createReceipt({
          goods,
          userId: 1
        })
        this.$emit('update')
      } catch (e) {
        console.log('CREATE RECEIPT ERROR', e)
      }
    
    }
  }
}
</script>

<style scoped>
  h2 {
    margin: 0 0 20px;
    text-align: center;
  }
</style>


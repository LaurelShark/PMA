<template>
  <el-form label-position="top">
    <div v-for="(item, index) in form.products"
      :key="index">
      <h2>
        Create order
      </h2>
      <el-form-item label="Good id">  
       <el-select
            v-model="form.products[index].id"
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
        <el-input v-model="form.products[index].amount">
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
        products: [
          {
            id: null,
            amount: null
          }
        ]
      },
      dialogVisible: false
    }
  },

  computed: {
    ...mapState('Goods', [
      'goods'
    ])
  },

  methods: {
    ...mapActions('Orders', [
      'createOrder'
    ]),

    ...mapActions('Goods', [
      'loadGoods'
    ]),

    openDialog() {
      this.dialogVisible = true
    },

    closeDialog() {
      this.dialogVisible = false
    },

    addItem() {
      this.form.products.push(
        {
          id: null,
          amount: null,
        }
      )
    },

    async onSubmit() {
      const products = this.form.products.reduce((res, { id, amount }) => {
        return {
          ...res,
          [`${id}`]: `${amount}`
        }
      }, {})

      try {
         await this.createOrder({
          userId: 2,
          providerId: 3,
          products
        })
        this.$emit('update')
        this.closeDialog()
      } catch (e) {

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


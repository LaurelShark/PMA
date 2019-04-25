<template>
  <el-form label-width="175px" label-position="right">
    <el-form-item label="Name">
      <el-input
        v-model="form.name"
      />
    </el-form-item>
    <el-form-item label="Category">
      <el-select v-model="form.categoryId">
        <el-option 
          v-for="item in categories"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        />
      </el-select>
    </el-form-item>
      <el-form-item label="Department">
        <el-input v-model.number="form.departmentId"></el-input>
    </el-form-item>
    <el-form-item label="Unique id">
      <el-input
        v-model="form.uniqueId"
      />
    </el-form-item>
      <el-form-item label="Amount">
      <el-input
        v-model="form.amount"
      />
    </el-form-item>
    <el-form-item label="Min amount">
      <el-input
        v-model="form.minAmount"
      />
    </el-form-item>
    <el-form-item label="Price">
      <el-input
        v-model="form.price"
      />
    </el-form-item>

    <el-form-item>
      <el-button
        type="success"
        @click="onSubmit"
      >
        Create
      </el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.prepareInitState()
  },

  data() {
    return {
      form: {
        name: null,
        categoryId: null,
        departmentId: null,
        uniqueId: null,
        providerId: null,
        amount: null,
        minAmount: null,
        price: null
      },
      dialogVisible: true
    }
  },

  computed: {
    ...mapState('Categories', [
      'categories'
    ])
  },

  methods: {
     ...mapActions('Categories', [
      'loadCategories'
    ]),

    ...mapActions('Goods', [
      'createGood'
    ]),

    openDialog() {
      this.dialogVisible = true
    },

    prepareInitState() {
      this.loadCategories()
    },

    async onSubmit() {
      try {
        await this.createGood({
          ...this.form
        })
        this.$emit('update')
      } catch (e) {
        console.log('FORM GOOD', e)
      }
    }
  }
}
</script>

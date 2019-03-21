<template>
  <el-row>
    <el-col :span="20">
      <orders-list />
    </el-col>
    <el-col :span="4">
      <el-button
        type="primary"
        icon="el-icon-plus"
        @click="openForm"
      >
        Create
      </el-button>
    </el-col>

    <orders-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import OrdersForm from './Form'
import OrdersList from './List'

export default {
  components: {
    OrdersForm,
    OrdersList
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
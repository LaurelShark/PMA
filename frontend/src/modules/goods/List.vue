<template>
  <el-table :data="goods">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="name"
      label="Name"
    />
    <el-table-column
      prop="categoryId"
      label="Category id"
    />
    <el-table-column
      prop="departmentId"
      label="Department id"
    />
    <el-table-column
      prop="amount"
      label="Amount"
    />
    <el-table-column
      prop="minAmount"
      label="Min amount"
    />
	<el-table-column
      prop="price"
      label="Price"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  computed: {
    ...mapState('Goods', [
      'goods'
    ])
  },

  

}
</script>
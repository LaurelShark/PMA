<template>
  <el-table :data="tableData">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="name"
      label="Name"
    />
    <el-table-column
      prop="category_id"
      label="Category id"
    />
    <el-table-column
      prop="department_id"
      label="Department id"
    />
    <el-table-column
      prop="amount"
      label="Amount"
    />
    <el-table-column
      prop="min_amount"
      label="Min amount"
    />
  </el-table>
</template>

<script>
export default {
  computed: {
    tableData() {
      return [
        {
          id: 1,
          name: 'Hello World',
          category_id: 2,
          department_id: 34,
          provider_id: 55,
          amount: 44,
          min_amount: 30,
          price: 55
        }
      ]
    }
  }
}
</script>
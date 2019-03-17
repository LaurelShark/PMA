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
      prop="surname"
      label="Surame"
    />
    <el-table-column
      prop="email"
      label="email"
    />
    <el-table-column
      prop="department_id"
      label="Department id"
    />
    <el-table-column
      prop="salary"
      label="Salary"
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
          department_id: 2,
          email: 'test@user.com',
          name: 'Oleksandr',
          surname: 'Lavrenchuk',
          salary: 15000
        }
      ]
    }
  }
}
</script>
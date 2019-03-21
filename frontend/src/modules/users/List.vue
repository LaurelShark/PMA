<template>
  <el-table :data="users">
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
      prop="departmentId"
      label="Department id"
    />
    <el-table-column
      prop="salary"
      label="Salary"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadUsers()
  },
  computed: {
    ...mapState('Users', [
      'users'
    ])
  },

  methods: {
    ...mapActions('Users', [
      'loadUsers'
    ]),
  }

}
</script>
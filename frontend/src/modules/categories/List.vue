<template>
  <el-table :data="categories">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="name"
      label="Name"
    />
  </el-table>
</template>

<script>
import { mapState } from 'vuex'

export default {
  computed: {
    ...mapState('Categories', [
      'categories'
    ])
  }
}
</script>
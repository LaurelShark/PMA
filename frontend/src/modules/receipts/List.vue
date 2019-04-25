<template>
  <el-table 
    :data="receipts"
    @row-click="rowClick"
  >
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="userId"
      label="User id"
    />
    <el-table-column
      prop="date"
      label="Date"
    />
    <el-table-column
      prop="totalSum"
      label="Total sum"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  computed: {
    ...mapState('Receipts', [
      'receipts'
    ])
  },

  methods: {
    rowClick(row) {
      
    }
  }

}
</script>
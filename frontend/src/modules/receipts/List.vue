<template>
  <el-table :data="receipts">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="user_id"
      label="User id"
    />
    <el-table-column
      prop="date"
      label="Date"
    />
    <el-table-column
      prop="total_sum"
      label="Total sum"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadReceipts()
  },
  computed: {
    ...mapState('Receipts', [
      'receipts'
    ])
  },

  methods: {
    ...mapActions('Receipts', [
      'loadReceipts'
    ]),
  }

}
</script>
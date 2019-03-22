<template>
  <el-table :data="orders">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="userId"
      label="User id"
    />
    <el-table-column
      prop="status"
      label="Status"
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
  created() {
    this.loadOrders()
  },
  computed: {
    ...mapState('Orders', [
      'orders'
    ])
  },

  methods: {
    ...mapActions('Orders', [
      'loadOrders'
    ]),
  }

}
</script>
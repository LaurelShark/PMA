<template>
  <el-table :data="supplies">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="providerId"
      label="Provider id"
    />
    <el-table-column
      prop="orderId"
      label="Order id"
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
    this.loadSupplies()
  },
  computed: {
    ...mapState('Supplies', [
      'supplies'
    ])
  },

  methods: {
    ...mapActions('Supplies', [
      'loadSupplies'
    ]),
  }

}
</script>
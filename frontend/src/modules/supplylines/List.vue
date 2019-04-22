<template>
  <el-table :data="supplylines">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="goodId"
      label="Good id"
    />
    <el-table-column
      prop="supplyId"
      label="Supply id"
    />
    <el-table-column
      prop="price"
      label="Price"
    />
    <el-table-column
      prop="amount"
      label="Amount"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadSupplyLines()
  },
  computed: {
    ...mapState('SupplyLines', [
      'supplylines'
    ])
  },

  methods: {
    ...mapActions('SupplyLines', [
      'loadSupplyLines'
    ]),
  }

}
</script>
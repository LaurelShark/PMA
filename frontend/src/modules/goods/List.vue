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
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadGoods()
  },
  computed: {
    ...mapState('Goods', [
      'goods'
    ])
  },

  methods: {
    ...mapActions('Goods', [
      'loadGoods'
    ]),
  }

}
</script>
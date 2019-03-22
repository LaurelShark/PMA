<template>
  <el-table :data="providers">
    <el-table-column
      prop="id"
      label="Id"
    />
    <el-table-column
      prop="name"
      label="Name"
    />
    <el-table-column
      prop="personName"
      label="Person name"
    />
    <el-table-column
      prop="phone"
      label="Phone"
    />
    <el-table-column
      prop="address"
      label="Address"
    />
    <el-table-column
      prop="cardNumber"
      label="Card number"
    />
  </el-table>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadProviders()
  },
  computed: {
    ...mapState('Providers', [
      'providers'
    ])
  },

  methods: {
    ...mapActions('Providers', [
      'loadProviders'
    ]),
  }

}
</script>
<template>
  <div>
    <form-wrapper
      ref="form"
    >
      <update-form
        :orderId="orderIdToUpdate"
        @update="onUpdate"
      />
    </form-wrapper>

    <el-table 
      :data="orders"
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
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import UpdateForm from './UpdateForm'

export default {
  data() {
    return {
      orderIdToUpdate: null
    }
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

    rowClick({ id }) {
      this.orderIdToUpdate = id
      this.openForm()
    },

    openForm() {
      this.$refs.form.openForm()
    },

    onUpdate() {
      
    }
  },

  components: {
    UpdateForm
  }

}
</script>
<template>
  <el-row>
    <el-col :span="20">
      <orders-list />
    </el-col>
    <el-col :span="4">
      <el-button
        type="primary"
        icon="el-icon-plus"
        @click="openForm"
      >
        Create
      </el-button>
    </el-col>
    <form-wrapper
      ref="form"
    >
      <orders-form
        @update="onCreate"
      />
    </form-wrapper>
    <form-wrapper
      ref="updateForm"
    >
      <update-form
        :orderId="orderIdToUpdate"
        @update="onUpdate"
      />
    </form-wrapper>
  </el-row>
  
</template>

<script>
import OrdersForm from './Form'
import UpdateForm from './UpdateForm'
import OrdersList from './List'
import { mapState, mapActions } from 'vuex'

export default {
  created() {
    this.loadOrders()
  },

  data() {
    return {
      orderIdToUpdate: null
    }
  },


  components: {
    OrdersForm,
    OrdersList,
    UpdateForm
  },

  methods: {
    ...mapActions('Orders', [
      'loadOrders'
    ]),

    rowClick(row) {
      console.log(row)
    },

    onCreate() {
      this.closeForm()
      this.loadOrders()
    },

    onUpdate() {
      this.closeUpdateForm()
      this.loadOrders()
    },
    
    openForm() {
      this.$refs.form.openForm()
    },

    closeForm() {
      this.$refs.form.closeForm()
    },

    openUpdateForm() {
      this.$refs.updateForm.openForm()
    },

    closeUpdateForm() {
      this.$refs.updateForm.closeForm()
    }
  }
}
</script>
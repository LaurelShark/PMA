<template>
  <el-row>
    <el-col :span="20">
      <receipt-list />
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
      <receipt-form
        @update="onUpdate"
      />
    </form-wrapper>
  </el-row>
  
</template>

<script>
import ReceiptForm from './Form'
import ReceiptList from './List'
import { mapActions } from 'vuex'

export default {
  created() {
    this.loadReceipts()
  },

  components: {
    ReceiptForm,
    ReceiptList
  },

  methods: {
    ...mapActions('Receipts', [
      'loadReceipts'
    ]),

    openForm() {
      this.$refs.form.openForm()
    },

    closeForm() {
      this.$refs.form.closeForm()
    },

    onUpdate() {
      this.loadReceipts()
      this.closeForm()
    }
  }
}
</script>
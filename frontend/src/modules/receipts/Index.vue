<template>
  <el-row>
    <el-col :span="20">
      111
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

    <receipt-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import ReceiptForm from './Form'

export default {
  components: {
    ReceiptForm
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
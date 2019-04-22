<template>
  <el-row>
    <el-col :span="20">
      <supplies-list />
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

    <supplies-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import SupplyLinesForm from './Form'
import SupplyLinesList from './List'

export default {
  components: {
    SupplyLinesForm,
    SupplyLinesList
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
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
import SuppliesForm from './Form'
import SuppliesList from './List'

export default {
  components: {
    SuppliesForm,
    SuppliesList
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
<template>
  <el-row>
    <el-col :span="20">
      <providers-list />
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

    <provider-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import ProvidersList from './List'
import ProviderForm from './Form'

export default {
  components: {
    ProvidersList,
    ProviderForm
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
<template>
  <el-row>
    <el-col :span="20">
      <users-list />
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

    <user-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import UsersList from './List'
import UserForm from './Form'

export default {
  components: {
    UsersList,
    UserForm
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
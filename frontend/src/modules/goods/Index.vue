<template>
  <el-row>
    <el-col :span="20">
      <goods-list />
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

    <good-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import GoodsList from './List'
import GoodForm from './Form'

export default {
  components: {
    GoodsList,
    GoodForm
  },

  methods: {
    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>
<template>
  <el-dialog
    :visible.sync="formVisible"
    width="550px"
  >
    <slot v-if="formVisible" />
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      formVisible: false
    }
  },

  methods: {
    openForm() {
      this.formVisible = true
    },

    closeForm() {
      this.formVisible = false
    }
  }
}
</script>

<style>

</style>

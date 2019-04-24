<template>
  <el-dialog
    :visible.sync="dialogVisible"
    width="550px"
  >
    <el-form label-width="175px" label-position="right">
      <el-form-item label="Name">
        <el-input
          v-model="form.name"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="success"
          @click="onSubmit"
        >
          Create
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  data() {
    return {
      form: {
        name: null
      },
      dialogVisible: false
    }
  },

  computed: {

  },

  methods: {
     ...mapActions('Categories', [
      'createCategory'
    ]),

    openDialog() {
      this.dialogVisible = true
    },

    closeDialog() {
      this.dialogVisible = false
    },

    async onSubmit() {
      try {
        await this.createCategory({
          name: this.form.name
        })
      } catch (e) {
        console.log(e, 'error')
      }
     

      this.closeDialog()
    }
  }
}
</script>

<template>
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
</template>

<script>
import { mapActions } from 'vuex'

export default {
  data() {
    return {
      form: {
        name: null
      }
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
        this.$emit('update')
      } catch (e) {
        
      }
      
    }
  }
}
</script>

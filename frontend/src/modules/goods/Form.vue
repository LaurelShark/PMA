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
      <el-form-item label="Category">
        <el-select v-model="form.category">
          <el-option 
            label="Cars"
            value="car"
          />
        </el-select>
      </el-form-item>
       <el-form-item label="Department">
        <el-select v-model="form.department" >
          <el-option 
            label="Cars"
            value="car"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="Unique id">
        <el-input
          v-model="form.unique_id"
        />
      </el-form-item>
      <el-form-item label="Min amount">
        <el-input
          v-model="form.amount"
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
export default {
  data() {
    return {
      form: {
        name: null,
        category: null,
        department: null,
        unique_id: null,
        provider_id: null,
        amount: null,
        min_amount: null,
        price: null
      },
      dialogVisible: false
    }
  },

  methods: {
    openDialog() {
      this.dialogVisible = true
    },

    closeDialog() {
      this.dialogVisible = false
    },

    onSubmit() {
      //
      this.closeDialog()
    }
  }
}
</script>

<template>
  <el-dialog
    :visible.sync="dialogVisible"
    width="550px"
  >
    <el-form label-position="top">
      <div v-for="(item, index) in form.items"
        :key="index">
        <h2>
          Receipt line
        </h2>
        <el-form-item label="Good id">  
          <el-input v-model="form.items[index].id">
          </el-input>
        </el-form-item>
        <el-form-item label="Amount">
          <el-input v-model="form.items[index].amount">
          </el-input>
        </el-form-item>
        <el-form-item label="Price">
          <el-input v-model="form.items[index].price">
          </el-input>
        </el-form-item>
      </div>
      
      <el-button
        type="success"
        @click="addItem"
      >
        Add new
      </el-button>
      
      <el-button
        type="success"
        @click="onSubmit"
      >
        Create
      </el-button>
      
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      form: {
        items: [
          {
            id: null,
            amount: null,
            price: null
          }
        ]
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

    addItem() {
      this.form.items.push(
        {
          id: null,
          amount: null,
          price: null
        }
      )
    },

    onSubmit() {
      //
      this.closeDialog()
    }
  }
}
</script>

<style scoped>
  h2 {
    margin: 0 0 20px;
    text-align: center;
  }
</style>


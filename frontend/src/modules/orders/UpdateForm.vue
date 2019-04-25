<template>
  <el-form label-position="top">
    <div>
      <h2>
        Update order
      </h2>
      <el-form-item label="status">
        <el-input v-model="form.status">
        </el-input>
      </el-form-item>
    </div>
    <el-button
      type="success"
      @click="onSubmit"
    >
      Update
    </el-button>
  </el-form>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  data() {
    return {
      form: {
        status: null
      },
      
    }
  },

  computed: {
    ...mapState('Goods', [
      'goods'
    ])
  },

  methods: {
    ...mapActions('Orders', [
      'createOrder',
      'updateOrder'
    ]),

    openDialog() {
      this.dialogVisible = true
    },

    closeDialog() {
      this.dialogVisible = false
    },


    async onSubmit() {
      try {
         await this.updateOrder({
          status: this.form.status
        })
        this.$emit('update')
        this.closeDialog()
      } catch (e) {
        
      }
     
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


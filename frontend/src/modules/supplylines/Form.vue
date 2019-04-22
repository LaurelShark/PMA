<template>
 
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
            price: null,
			goodId: null,
			supplyId: null
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
          price: null,
		  goodId: null,
	      supplyId: null
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


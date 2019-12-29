<template>
    <ve-line :data="chartData" :settings="chartSettings"></ve-line>
</template>

<script>
    export default {
        name: "line",
        props: {
            value: []
        },
        data() {
            return {
                chartSettings:${chartSettings},
                chartData:${chartData}
            }
        },
        methods: {},
        watch:{
            value: function (newval) {
                this.chartData.rows=rows
            }
        }
    }
</script>

<style scoped>

</style>

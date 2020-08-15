const dingdan = {
    template: "#dingdan",
    data() {
        return {
            currentPage: 1,// 当前页码
            pageSize: 10,// 每页大小
            total: 1,
            orderPageList: {}
        }
    },
    methods: {
        handleSizeChange(val) {
            this.orderPageInFo(val);
        },
        handleCurrentChange(val) {
            this.orderPageInFo(val);
        },
        handleDelete(index, row) {
            axios({
                method: "post",
                url: "/deleteOrderInFo",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    id: row.oid,
                }
            }).then((response) => {
                if (response.data) {
                    this.orderPageInFo(this.currentPage);
                } else {
                    this.$notify({
                        title: '删除失败',
                        message: '订单删除失败，请稍后重试！',
                        position: 'bottom-right'
                    });
                }
            })
        },
        orderPageInFo(pageNumber) {
            axios({
                method: "post",
                url: "/orderPageInFo",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    pageNumber: pageNumber,
                }
            }).then((response) => {
                this.orderPageList = response.data.list;
                this.currentPage = response.data.pageNum;
                this.pageSize = response.data.pageSize;
                this.total = response.data.total;
                console.log(this.orderPageList)
            })

        }
    },
    mounted() {
        this.orderPageInFo(1);
    }
};
const app = new Vue({
    el: "#app",
    components: {
        dingdan
    }
});
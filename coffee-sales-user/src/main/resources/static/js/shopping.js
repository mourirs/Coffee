const show = {
    template: "#show",
    props: {
        ytid: {}
    },
    data() {
        return {
            commodity: {},
            tid: this.ytid,
            currentPage: 1,// 当前页码
            pageSize: 4,// 每页大小
            total: 12
        }
    },
    filters: {
        showPrice(price) {
            return "￥" + price.toFixed(2)
        }
    },
    methods: {
        getAllCommodity(pageNumber, value) {
            axios({
                method: "post",
                url: "/commodityList",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    pageNumber: pageNumber,
                    Id: value
                }
            }).then((response) => {
                this.commodity = response.data.list;
                this.currentPage = response.data.pageNum;
                this.pageSize = response.data.pageSize;
                this.total = response.data.total;
            })
        },
        handleSizeChange(val) {
            this.getAllCommodity(val, this.tid);
        },
        handleCurrentChange(val) {
            this.getAllCommodity(val, this.tid);
        },
        addToCart(index) {
            axios({
                method: "post",
                url: "/addCar",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    yId: this.commodity[index].yid,
                    cNum: 1
                }
            }).then((response) => {
                if (response.data) {
                    this.$notify({
                        title: '添加成功',
                        message: '宝贝正在购物车等你！',
                        position: 'bottom-right'
                    });
                } else {
                    this.$notify({
                        title: '添加失败',
                        message: '宝贝添加失败，请稍后重试！',
                        position: 'bottom-right'
                    });
                }
            })
        }
    },
    mounted() {
        this.getAllCommodity(1, this.tid);
    }
};
const app = new Vue({
    el: "#app",
    data() {
        return {
            activeNames: ['0', '1'],
            collapseTitle: []
        };
    },
    methods: {
        getCommodityTypeListTitle() {
            axios.get("/commodityTypeList").then((response) => {
                this.collapseTitle = response.data
            });
        }
    },
    mounted() {
        this.getCommodityTypeListTitle();
    },
    components: {
        show
    }
});
const car = {
    template: "#car",
    data() {
        return {
            num: 1,
            tableData: [],
            currentPage: 1,// 当前页码
            pageSize: 10,// 每页大小
            total: 1,
            multipleSelection: [],

        }
    },
    methods: {
        settlement() {
            sessionStorage.setItem("shoppingCar", JSON.stringify(this.multipleSelection));
            window.location.replace("http://localhost/createOrder")
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        handleChange(value, row) {
            axios({
                method: "post",
                url: "/updateCar",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    cId: row.cid,
                    cNum: value
                }
            }).then((response) => {
                if (response.data) {
                    this.carInFo(this.currentPage);
                } else {
                    this.$notify({
                        title: '增加失败',
                        message: '请稍后重试！',
                        position: 'bottom-right'
                    });
                }
            })
        },
        handleSizeChange(val) {
            this.carInFo(val);
        },
        handleCurrentChange(val) {
            this.carInFo(val);
        },
        handleDelete(index, row) {
            axios({
                method: "post",
                url: "/deleteCarForCId",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    id: row.cid,
                }
            }).then((response) => {
                if (response.data) {
                    this.carInFo(this.currentPage);
                } else {
                    this.$notify({
                        title: '删除失败',
                        message: '请稍后重试！',
                        position: 'bottom-right'
                    });
                }
            })
        },
        carInFo(pageNumber) {
            axios({
                method: "post",
                url: "/carPageInfo",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    pageNumber: pageNumber,
                }
            }).then((response) => {
                this.tableData = response.data.list;
                this.currentPage = response.data.pageNum;
                this.pageSize = response.data.pageSize;
                this.total = response.data.total;
            })
        },
        getSummaries(param) {
            const {columns, data} = param;
            const sums = [];
            columns.forEach((column, index) => {
                if (index === 1) {
                    sums[index] = '合计';
                    return;
                }
                if (index === 2) {
                    const values = data.map(item => Number(item.commodity.yprice));
                    if (!values.every(value => isNaN(value))) {
                        sums[index] = values.reduce((prev, curr) => {
                            const value = Number(curr);
                            if (!isNaN(value)) {
                                return prev + curr;
                            } else {
                                return prev;
                            }
                        }, 0);
                        sums[index] += ' 元';
                    } else {
                        sums[index] = 'N/A';
                    }
                }
                if (index === 3) {
                    const values = data.map(item => Number(item.cnum));
                    if (!values.every(value => isNaN(value))) {
                        sums[index] = values.reduce((prev, curr) => {
                            const value = Number(curr);
                            if (!isNaN(value)) {
                                return prev + curr;
                            } else {
                                return prev;
                            }
                        }, 0);
                        sums[index] += ' 个';
                    } else {
                        sums[index] = 'N/A';
                    }
                }
                if (index === 4) {
                    const values = data.map(function (value) {
                        return value.commodity.yprice * value.cnum
                    }).reduce((function (pre, n) {
                        return pre + n;
                    }), 0);
                    sums[index] = values + ' 元';
                }
            });
            return sums;
        }
    },
    mounted() {
        this.carInFo(1);
    },
    filters: {
        showPrice(price) {
            return "￥" + price.toFixed(2)
        }
    },

};
const app = new Vue({
    el: "#app",
    components: {
        car
    }
});
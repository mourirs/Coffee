const app = new Vue({
    el: "#app",
    data() {
        return {
            uName: "",
            uPwd: "",
            uEmail: ""
        }
    },
    methods: {
        register() {
            let regName = /^[A-Za-z0-9]{4,15}$/;
            let regPwd = /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
            let regEmail = /^[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*@([A-Za-z0-9\-]+\.)+[A-Za-z]{2,6}$/;
            if (regName.test(this.uName) && regPwd.test(this.uPwd) && regEmail.test(this.uEmail)) {
                axios({
                    method: "post",
                    url: "/userRegister",
                    transformRequest: [
                        function (data) {
                            return parseParams(data);
                        }
                    ],
                    data: {
                        uName: this.uName,
                        uPwd: this.uPwd,
                        uEmail: this.uEmail
                    }
                }).then((response) => {
                    if (response.data) {
                        this.registerSuccess();
                    } else {
                        this.registerError();
                    }
                })
            } else {
                this.inputNoData();
            }
        },
        inputNoData() {
            this.$alert('请输入完整的用户名、密码和邮箱;用户名只能包括数字字母的组合，长度为4-15位;' +
                '密码长度在6~18之间，只能包含字母、数字和下划线', '用户名、密码或邮箱格式错误', {
                confirmButtonText: '确定'
            });
        },
        registerError() {
            this.$alert('请检查用户名、密码、邮箱是否错误', '注册失败', {
                confirmButtonText: '确定'
            });
        },
        registerSuccess() {
            this.$confirm('是否跳转到登录界面？', '注册成功', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'success'
            }).then(() => {
                window.location.replace("http://localhost/login")
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消跳转'
                });
            });
        }
    }
});
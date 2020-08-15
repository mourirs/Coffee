const app = new Vue({
    el: "#app",
    data() {
        return {
            active: 1,
            uName: "",
            uPwd: "",
            uEmail: "",
            uPhone: "",
            dialogFormVisible: false,
            innerVisible: false,
            form: {
                newPwd: "",
                aNewPwd: ""
            },
            formLabelWidth: '120px'
        };
    },
    methods: {
        next() {
            if (this.active++ >= 3) {
                this.active = 3
            }
        },
        previous() {
            if (this.active-- <= 1) {
                this.active = 1
            }
        },
        success() {
            axios(
                {
                    method: "post",
                    url: "/userRetrieve",
                    transformRequest: [
                        function (data) {
                            return parseParams(data);
                        }
                    ],
                    data: {
                        uName: this.uName,
                        uPwd: this.uPwd,
                        uEmail: this.uEmail,
                        uPhone: this.uPhone
                    }
                }
            ).then((response) => {
                if (response.data) {
                    this.retrieveSuccess()
                } else {
                    this.retrieveError();
                }
            })
        },
        retrieveError() {
            this.$alert('请检查用户名、密码、邮箱、手机号是否错误', '找回失败', {
                confirmButtonText: '确定'
            });
        },
        retrieveSuccess() {
            this.dialogFormVisible = true;
        },
        retrievePwd() {
            let regPwd = /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
            if (this.form.newPwd === this.form.aNewPwd && regPwd.test(this.form.newPwd)) {
                axios(
                    {
                        method: "post",
                        url: "/userRetrievePassword",
                        transformRequest: [
                            function (data) {
                                return parseParams(data);
                            }
                        ],
                        data: {
                            uName: this.uName,
                            uPwd: this.form.newPwd,
                            uEmail: this.uEmail
                        }
                    }
                ).then((response) => {
                    if (response.data) {
                        this.dialogFormVisible = false;
                        this.retrievePwdSuccess();
                    } else {
                        this.innerVisible = true;
                    }
                })
            } else {
                this.innerVisible = true;
            }
        },
        retrievePwdSuccess() {
            this.$confirm('是否跳转到登录界面？', '重置密码成功', {
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
})
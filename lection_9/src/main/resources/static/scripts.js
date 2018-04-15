var app = new Vue({
    el: '#app',
    data: {
        showEditor: false,
        showInfo: false,
        summaries: [],
        summary: {},
        editId: 0,
        isEdit: false
    },
    methods: {
        getAllSummary: function () {
            axios.get('/api/all')
                .then((response) => {
                    this.summaries = response.data;
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        getSummary: function (id) {
            axios.get('/api/summary/' + id)
                .then((response) => {
                    this.summary = response.data;
                    this.showInfo = true;
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        removeSummary: function (id) {
            axios.delete('/api/delete/' + id)
                .then(() => {
                    this.getAllSummary();
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        closeSummary: function () {
            this.summary = {};
            this.showInfo = false;
        },
        appendSummary: function () {
             axios.post('/api/new', this.summary)
                 .then(() => {
                     this.getAllSummary();
                     this.showEditor = false;
                 })
                 .catch((error) => {
                     console.log(error);
                 });
        },
        editSummary: function (id) {
            this.isEdit = true;
            axios.get('/api/summary/' + id)
                .then((response) => {
                    this.editId = id;
                    this.summary = response.data;
                    this.showEditor = true;
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        updateSummary: function () {
            axios.put('/api/edit/' + this.editId, this.summary)
                .then((response) => {
                    this.editId = -1;
                    this.summary = {};
                    this.showEditor = false;
                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }
});

app.getAllSummary();

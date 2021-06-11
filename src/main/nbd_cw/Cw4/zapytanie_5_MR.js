db.people.mapReduce(
    function () {
        this.credit.forEach( c => {
            emit(c.currency, c.balance)
        });
    },

    function (key, values) {
        return {
            sum: values.reduce((a, b) => a + b, 0),
            avg: values.reduce((a, b) => a + b, 0)/values.length
        }
    },
    {
        query: {sex: "Female", nationality: "Poland"},
        out: 'zapytanie_5_MR'
    }
);

printjson(db.zapytanie_5_MR.find().toArray());
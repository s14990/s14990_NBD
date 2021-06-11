db.people.mapReduce(
    function () {
        this.credit.forEach( c => {
            emit(c.currency, c.balance)
        });
    },

    function (key, values) {
        return values.reduce((a, b) => a + b, 0)
    },
    {out: 'zapytanie_2_MR'}
);

printjson(db.zapytanie_2_MR.find().toArray());
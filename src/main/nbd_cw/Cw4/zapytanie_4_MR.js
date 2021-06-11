db.people.mapReduce(
    function () {
        let bmi=this.weight / Math.pow(this.height / 100, 2);
        emit(this.nationality,bmi)
    },
    function (key, values) {
        return {
            avg: values.reduce((a, b) => a + b, 0)/values.length,
            min: Math.min(...values),
            max: Math.max(...values),
        }
    },
    {out: 'zapytanie_4_MR'}
);

printjson(db.zapytanie_4_MR.find().toArray());
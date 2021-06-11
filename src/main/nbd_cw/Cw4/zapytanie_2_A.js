printjson(db.people.aggregate([
    {$unwind: ("$credit")},
    {$group: {_id: "$credit.currency", sum: {$sum: "$credit.balance"}}}
]).toArray());
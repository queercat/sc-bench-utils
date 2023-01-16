using import .time
using import Array

fn create-array ()
    for x in (range 0 100)
        local values = ((Array i64))
        for y in (range 0 10000)
            'append values y

for _ in (range 0 100)
    time-it create-array

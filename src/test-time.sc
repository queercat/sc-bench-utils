using import .time
using import Array
using import format

fn create-array ()
    for x in (range 0 100)
        local values = ((Array i64))
        for y in (range 0 10000)
            'append values y

let iterations = 100
let average-time = (time-trial create-array iterations)

print 
    .. (format "on average {} took {}s over {} iterations" create-array average-time iterations)

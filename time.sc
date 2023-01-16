let time = (include "time.h")

let tm =
    time.struct.tm

fn get-time ()
    local timespec-struct =
        (time.struct.timespec)

    (time.extern.clock_gettime 0 &timespec-struct)

    let ns = 
        (timespec-struct.tv_nsec / (pow 10 9))
    let s = 
        (timespec-struct.tv_sec as f64) 

    # time since epoch
    let tse =
        s + ns

while true
    print "time since epoch"
    print (get-time)

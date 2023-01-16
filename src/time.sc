using import format
using import String

let time = (include "time.h")

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

inline time-it (func)
    local start-time = (get-time)
    call func
    local end-time = (get-time)

    let duration = (end-time - start-time)
    print 
        .. (format "{} took {}s" func duration)

locals;


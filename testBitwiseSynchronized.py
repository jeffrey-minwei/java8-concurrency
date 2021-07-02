#!/usr/bin/env python3

import subprocess
count = 0;
while count < 1000000:
        subprocess.call(["java", "-ea", "BitwiseNegSynchronized"]);
        count += 1;

#!/usr/bin/env python3

import subprocess
count = 0;
while count < 2000:
        subprocess.call(["java", "-ea", "BitwiseNegation"]);
        count += 1;

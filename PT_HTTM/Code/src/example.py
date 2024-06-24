import torch
from matplotlib import pyplot as plt
import numpy as np
import cv2
import uuid
import os
import time

model = torch.hub.load("ultralytics/yolov5", "yolov5s")
path = "D:\Tai_lieu_ki_1_nam_4\PT_HTTM\Code\yolov5\AW.mp4"
##ex
# img = "https://th.bing.com/th/id/OIF.ddcFGq1EsnHm3cZsr6YLsw?pid=ImgDet&rs=1"

# result = model(img)
# result.print()

# # %matplotlib inline
# plt.imshow(np.squeeze(result.render()))
# plt.show()

# result.xyxy

cap = cv2.VideoCapture(0)
while cap.isOpened():
    ret, frame = cap.read()

    result = model(frame)

    cv2.imshow("YOLO", np.squeeze(result.render()))

    if cv2.waitKey(10) & 0xFF == ord("q"):
        break
cap.release()
cv2.destroyAllWindows()

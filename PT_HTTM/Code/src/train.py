import torch
from matplotlib import pyplot as plt
import numpy as np
import cv2
import uuid
import os
import time

model = torch.hub.load("ultralytics/yolov5", "yolov5s")
path = "D:\Tai_lieu_ki_1_nam_4\PT_HTTM\Code\yolov5\AW.mp4"

IMAGES_PATH = os.path.join("data", "images")
labels = ["tinh_tao", "buon_ngu"]
number_imgs = 20

cap = cv2.VideoCapture(0)
for label in labels:
    print("Collecting images for {}".format(label))
    time.sleep(5)
    for img_num in range(number_imgs):
        print("Collecting images for {}, image number {}".format(label, img_num))

        # Webcam feed
        ret, frame = cap.read()

        # Naming out image path
        imgname = os.path.join(IMAGES_PATH, label + "." + str(uuid.uuid1()) + ".jpg")

        # Writes out image to file
        cv2.imwrite(imgname, frame)

        # Render to the screen
        cv2.imshow("Image Collection", frame)

        # 2 second delay between captures
        time.sleep(2)

        if cv2.waitKey(10) & 0xFF == ord("q"):
            break
cap.release()
cv2.destroyAllWindows()

# print(os.path.join(IMAGES_PATH, labels[0] + "." + str(uuid.uuid1()) + ".jpg"))

# for label in labels:
#     print("Collecting images for {}, images number {}".format(label, img_num))
#     imgname = os.path.join(IMAGES_PATH, label + "." + str(uuid.uuid1) + ".jpg")
#     cv2.imwrite(imgname, frame)
#     print(label)

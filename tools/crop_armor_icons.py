#!/usr/bin/env python3
"""
Crop/resize armor texture sheets to 32x32 item icons.
Saves into src/main/resources/assets/minigames/textures/item/
"""
import os
from PIL import Image

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
# project root is parent of tools/
SRC = os.path.join(ROOT, 'src', 'main', 'resources', 'assets', 'minigames')
ARMOR_DIR = os.path.join(SRC, 'textures', 'models', 'armor')
ITEM_DIR = os.path.join(SRC, 'textures', 'item')
os.makedirs(ITEM_DIR, exist_ok=True)

mapping = {
    'lasergame_layer_1.png': ['lasergame_helmet.png', 'lasergame_chestplate.png'],
    'lasergame_layer_2.png': ['lasergame_leggings.png', 'lasergame_boots.png'],
}

for src_name, targets in mapping.items():
    src_path = os.path.join(ARMOR_DIR, src_name)
    if not os.path.exists(src_path):
        print(f"Source not found: {src_path}")
        continue
    try:
        im = Image.open(src_path).convert('RGBA')
    except Exception as e:
        print(f"Failed to open {src_path}: {e}")
        continue
    # Resize the whole sheet to 32x32 so it becomes an item icon
    icon = im.resize((32, 32), Image.LANCZOS)
    for t in targets:
        out_path = os.path.join(ITEM_DIR, t)
        icon.save(out_path)
        print(f"Wrote {out_path}")

print('Done')



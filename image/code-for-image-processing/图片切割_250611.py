from PIL import Image
import os

def process_image(input_path, output_folder):
    """处理图片：裁剪为正方形并分割成4x4网格"""
    try:
        # 确保输出文件夹存在
        os.makedirs(output_folder, exist_ok=True)
        
        # 打开原始图片
        img = Image.open(input_path)
        
        # 1. 裁剪为420x420正方形（从中心裁剪）
        width, height = img.size
        crop_size = min(width, height)
        left = (width - crop_size) // 2
        top = (height - crop_size) // 2
        right = left + crop_size
        bottom = top + crop_size
        
        # 先裁剪成正方形
        square_img = img.crop((left, top, right, bottom))
        
        # 调整大小为420x420
        square_img = square_img.resize((420, 420))
        
        # 保存完整的420x420图片为all.jpg
        square_img.save(os.path.join(output_folder, "all.jpg"))
        
        # 2. 分割成4x4网格（每块105x105）
        tile_size = 105
        tiles = []
        for i in range(4):
            for j in range(4):
                left = j * tile_size
                top = i * tile_size
                right = left + tile_size
                bottom = top + tile_size
                tile = square_img.crop((left, top, right, bottom))
                tiles.append(tile)
        
        # 3. 保存所有切片 (编号1.jpg到16.jpg)
        for idx, tile in enumerate(tiles, start=1):
            tile.save(os.path.join(output_folder, f"{idx}.jpg"))
        
        print(f"成功创建1张完整图和16张切片到文件夹: {output_folder}")
        print(f"完整图: all.jpg")
        print(f"小图: 1.jpg 到 16.jpg")
        return True
    
    except Exception as e:
        print(f"处理失败: {str(e)}")
        return False

if __name__ == "__main__":
    # 获取用户输入的图片路径
    input_image = '/Users/jiangyanze/Desktop/Coding/Python/HK03.jpg'
    
    # 检查文件是否存在
    if not os.path.isfile(input_image):
        print(f"错误: 文件 '{input_image}' 不存在")
        exit(1)
    
    # 使用图片所在目录+_tiles作为输出文件夹
    output_dir = os.path.join(
        os.path.dirname(input_image),
        os.path.splitext(os.path.basename(input_image))[0] + "_tiles"
    )
    
    process_image(input_image, output_dir)
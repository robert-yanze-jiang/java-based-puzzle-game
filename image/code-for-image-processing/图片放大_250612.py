from PIL import Image
import os

def resize_image_to_500x500(input_path, output_folder):
    """将图片调整为500x500像素"""
    try:
        # 确保输出文件夹存在
        os.makedirs(output_folder, exist_ok=True)
        
        # 打开原始图片
        img = Image.open(input_path)
        
        # 1. 裁剪为正方形（从中心裁剪）
        width, height = img.size
        crop_size = min(width, height)
        left = (width - crop_size) // 2
        top = (height - crop_size) // 2
        right = left + crop_size
        bottom = top + crop_size
        
        # 裁剪成正方形
        square_img = img.crop((left, top, right, bottom))
        
        # 2. 调整大小为500x500
        resized_img = square_img.resize((500, 500))
        
        # 3. 保存调整后的图片
        base_name = os.path.splitext(os.path.basename(input_path))[0]
        output_path = os.path.join(output_folder, f"{base_name}_500x500.png")
        resized_img.save(output_path)
        
        print(f"成功将图片调整为500x500并保存到: {output_path}")
        return True
    
    except Exception as e:
        print(f"处理失败: {str(e)}")
        return False

if __name__ == "__main__":
    # 输入图片路径
    input_image = '/Users/jiangyanze/Desktop/Coding/Python/background.png'
    
    # 检查文件是否存在
    if not os.path.isfile(input_image):
        print(f"错误: 文件 '{input_image}' 不存在")
        exit(1)
    
    # 使用图片所在目录+_resized作为输出文件夹
    output_dir = os.path.join(
        os.path.dirname(input_image),
        os.path.splitext(os.path.basename(input_image))[0] + "_resized"
    )
    
    resize_image_to_500x500(input_image, output_dir)
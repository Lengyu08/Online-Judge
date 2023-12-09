// 获取要容纳编辑器的元素
const editorElement = document.getElementById("editor");

// 获取语言和编辑模式的下拉框元素
const languageSelect = document.querySelector("select[name='language']");
const modeSelect = document.querySelector("select[name='mode']");

// 初始化 CodeMirror 编辑器
var editor = CodeMirror(editorElement, {
  // 初始配置，可以根据需要调整
  mode: "text/x-c++src",
  theme: "dracula",
  lineNumbers: true,
  matchBrackets: true,
  autoCloseBrackets: true,
  autoCloseTags: true,
  autoIndent: true,
  keyMap: "default",        // vim or default
  smartIndent: true, // 智能缩进
  indentUnit: 4, // 智能缩进单位为4个空格长度
  indentWithTabs: true, // 使用制表符进行智能缩进
  autofocus: true, // 自动聚焦
});

// 添加事件监听器，以便在选择框更改时更新编辑器配置
languageSelect.addEventListener("change", updateEditorConfig);
modeSelect.addEventListener("change", updateEditorConfig);

// 更新编辑器配置的函数
function updateEditorConfig() {
  // 获取选择框的值
  const selectedLanguage = languageSelect.value;
  const selectedMode = modeSelect.value;

  // 根据选择框的值更新编辑器配置
  editor.setOption("mode", selectedLanguage);                       // 设置语言模式
  editor.setOption("keyMap", selectedMode);                         // 设置编辑模式

  // python 和 c++ / java 的缩进的判断模式不一样
  if (selectedMode === "python") {
    editor.setOption("indentUnit", 4);
    editor.setOption("indentWithTabs", false);
    editor.setOption("smartIndent", false);
  }

  // 刷新编辑器以应用新配置
  editor.refresh();
}

function submitCode() {
  var code = editor.getValue(); // Get the code from CodeMirror
  console.log(code);

  // Create a hidden input element
  var hiddenInput = document.createElement("input");
  hiddenInput.type = "hidden";
  hiddenInput.name = "code";
  hiddenInput.value = code;

  // Append the hidden input to the form
  var codeForm = document.getElementById("codeForm");
  codeForm.appendChild(hiddenInput);

  // Submit the form
  codeForm.submit();
}